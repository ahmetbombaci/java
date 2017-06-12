package com.ahmetbombaci.aws;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;

/**
 * Hello AWS!
 * Credit to https://javatutorial.net/java-s3-example
 */
public class App 
{


	private static final String SUFFIX = "/";
	private static final String RESOURCE_FOLDER = "Z:/github/java/aws-practice/src/main/resources";
	private static Logger LOGGER = Logger.getLogger(App.class);
	private static Properties PROP = new Properties();
	
	
	public static void loadProperties() {
		InputStream inStream;
		try {
			inStream = new FileInputStream(RESOURCE_FOLDER+SUFFIX+"application.properties");
			PROP.load(inStream);
		} catch (FileNotFoundException e1) {
			LOGGER.error(e1);
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}
	
	public static void main(String[] args) {
		loadProperties();
		
		// credentials object identifying user for authentication
		// user must have AWSConnector and AmazonS3FullAccess for 
		// this example to work
		AWSCredentials credentials = new BasicAWSCredentials(
				PROP.getProperty("aws_access_key_id"), 
				PROP.getProperty("aws_secret_access_key"));
		
		// create a client connection based on credentials
		AmazonS3 s3client = new AmazonS3Client(credentials);
		
		// create bucket - name must be unique for all S3 users
		String bucketName = "abombaci-net-example-bucket";
		
		try {
			if(!s3client.doesBucketExist(bucketName)) {
				s3client.createBucket(bucketName);
				LOGGER.info("Bucket " + bucketName + " is created");
			} else {
				LOGGER.info("Bucket " + bucketName + " already exist");
			}
		} catch(AmazonS3Exception e) {
			LOGGER.error(e);
		}
		
		// list buckets
		for (Bucket bucket : s3client.listBuckets()) {
			LOGGER.info(" - " + bucket.getName());
		}
		
		// create folder into bucket
		String folderName = "testfolder";
		createFolder(bucketName, folderName, s3client);
		
		// upload file to folder and set it to public
		
		String fileName = folderName + SUFFIX + "upload_sample_file.txt";
		s3client.putObject(new PutObjectRequest(bucketName, fileName, 
				new File(RESOURCE_FOLDER+SUFFIX+"upload_sample_file.txt"))
				.withCannedAcl(CannedAccessControlList.PublicRead));
		
		//s3client.deleteObject(bucketName, folderName);
		if(args.length > 0 && "1".equals(args[0]))
			deleteFolder(bucketName, folderName, s3client);
		
		// deletes bucket
		if(args.length > 1 && "1".equals(args[1]))
			s3client.deleteBucket(bucketName);
	}
	
	public static void createFolder(String bucketName, String folderName, AmazonS3 client) {
		// create meta-data for your folder and set content-length to 0
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);
		// create empty content
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		// create a PutObjectRequest passing the folder name suffixed by /
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
				folderName + SUFFIX, emptyContent, metadata);
		// send request to S3 to create folder
		client.putObject(putObjectRequest);
	}
	
	
	/**
	 * This method first deletes all the files in given folder and than the
	 * folder itself
	 */
	public static void deleteFolder(String bucketName, String folderName, AmazonS3 client) {
		List<S3ObjectSummary> fileList = 
				client.listObjects(bucketName, folderName).getObjectSummaries();
		for (S3ObjectSummary file : fileList) {
			client.deleteObject(bucketName, file.getKey());
		}
		client.deleteObject(bucketName, folderName);
	}
	
	
}