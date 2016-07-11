package it.bmed.arch.uploadMulticanale.be.service.test;

import it.bmed.arch.uploadMulticanale.be.service.onboarding.OnBoardingServiceImpl;
import it.bmed.arch.uploadMulticanale.be.service.onboarding.OnBoardingServiceInterface;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by architetture on 20/06/16.
 */
public abstract class AbstractUnitTest {

    
    public OnBoardingServiceInterface onBoardingService = new OnBoardingServiceImpl();

    @BeforeClass
    public static void beforeClass() throws Exception {
        
    }

    @AfterClass
    public static void afterClass() throws Exception {

    }

    @Before
    public abstract void before() throws Exception;

    @After
    public abstract void after() throws Exception;

}
