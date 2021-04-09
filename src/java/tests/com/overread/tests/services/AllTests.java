package com.overread.tests.services;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AuthoritiesServiceTests.class, BlogServiceTests.class, CommentServiceTests.class,
		UserServiceTests.class })
public class AllTests
{
	public class TestRunner {
		
		public void main(String[] args) {
			Result result = JUnitCore.runClasses(SuiteClasses.class);
			
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
			
			System.out.println(result.wasSuccessful());
		}
	}
}
