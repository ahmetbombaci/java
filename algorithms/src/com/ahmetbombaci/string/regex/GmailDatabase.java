package com.ahmetbombaci.string.regex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://www.hackerrank.com/challenges/30-regex-patterns/problem
/*
Objective 
Today, we're working with regular expressions. Check out the Tutorial tab for learning materials and an instructional video!

Task 
Consider a database table, Emails, which has the attributes First Name and Email ID. Given N rows of data simulating the Emails table, print an alphabetically-ordered list of people whose email address ends in .

Input Format

The first line contains an integer, N, total number of rows in the table. 
Each of the N subsequent lines contains 2 space-separated strings denoting a person's first name and email ID, respectively.

Constraints

2<=N<=30
Each of the first names consists of lower case letters [a-z] only.
Each of the email IDs consists of lower case letters [a-z], @ and . only.
The length of the first name is no longer than 20.
The length of the email ID is no longer than 50.
Output Format

Print an alphabetically-ordered list of first names for every user with a gmail account. Each name must be printed on a new line.

Sample Input

6
riya riya@gmail.com
julia julia@julia.me
julia sjulia@gmail.com
julia julia@gmail.com
samantha samantha@gmail.com
tanya tanya@gmail.com
Sample Output

julia
julia
riya
samantha
tanya
*/
public class GmailDatabase {
	List<String> lines;
	
	GmailDatabase() {
		lines = new ArrayList<>();
		fillLines2();
	}
	
    
	public static void main(String[] args) {
		GmailDatabase gd = new GmailDatabase();
        Pattern p = Pattern.compile("^[a-z]{1,20}+ [a-z\\.]{1,40}+(@gmail\\.com)$");
        List<String> resultSet = new ArrayList<>();
        for(String line : gd.lines) {
            Matcher m = p.matcher(line);
            if(m.find()) {
                String s = m.group();
                String[] st = s.split(" ");
                resultSet.add(st[0]);
            }
        }
        
        Collections.sort(resultSet);
        for(String str:resultSet) {
            System.out.println(str);
        }
    }
	
	

    private void fillLines() {
		lines.add("riya riya@gmail.com");
		lines.add("julia julia@julia.me");
		lines.add("julia sjulia@gmail.com");
		lines.add("julia julia@gmail.com");
		lines.add("samantha samantha@gmail.com");
		lines.add("tanya tanya@gmail.com");
    	/*Expected output: 
julia
julia
riya
samantha
tanya
    	 */
	}


    private void fillLines2() {
    	lines.add("riya riya@gmail.com");
    	lines.add("julia julia@julia.me");
    	lines.add("julia sjulia@gmail.com");
    	lines.add("julia julia@gmail.com");
    	lines.add("samantha samantha@gmail.com");
    	lines.add("tanya tanya@gmail.com");
    	lines.add("riya ariya@gmail.com");
    	lines.add("julia bjulia@julia.me");
    	lines.add("julia csjulia@gmail.com");
    	lines.add("julia djulia@gmail.com");
    	lines.add("samantha esamantha@gmail.com");
    	lines.add("tanya ftanya@gmail.com");
    	lines.add("riya riya@live.com");
    	lines.add("julia julia@live.com");
    	lines.add("julia sjulia@live.com");
    	lines.add("julia julia@live.com");
    	lines.add("samantha samantha@live.com");
    	lines.add("tanya tanya@live.com");
    	lines.add("riya ariya@live.com");
    	lines.add("julia bjulia@live.com");
    	lines.add("julia csjulia@live.com");
    	lines.add("julia djulia@live.com");
    	lines.add("samantha esamantha@live.com");
    	lines.add("tanya ftanya@live.com");
    	lines.add("riya gmail@riya.com");
    	lines.add("priya priya@gmail.com");
    	lines.add("preeti preeti@gmail.com");
    	lines.add("alice alice@alicegmail.com");
    	lines.add("alice alice@gmail.com");
    	lines.add("alice gmail.alice@gmail.com");
    	
    	/*
    	 * Expected output: 
    	 * 
alice
alice
julia
julia
julia
julia
preeti
priya
riya
riya
samantha
samantha
tanya
tanya
    	 */
	}
    
}
