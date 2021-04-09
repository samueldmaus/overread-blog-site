package com.overread.tests.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AuthoritiesServiceTests.class, BlogServiceTests.class, CommentServiceTests.class,
		UserServiceTests.class })
public class AllTests
{

}
