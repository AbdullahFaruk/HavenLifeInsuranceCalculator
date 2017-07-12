package DriverUtils;

import com.havenlife.vision.BaseFramework.ApplicationController;

/**
 * Created by Abdullah on 6/25/17.
 */
public class ApplicationFactory {

    private static ApplicationFactory instance = new ApplicationFactory();

    private ApplicationFactory(){}

    public static ApplicationFactory getInstance()
    {
        return instance;
    }
    ThreadLocal<ApplicationController> applicationThreadLocal = new ThreadLocal<ApplicationController>(){
        @Override
        protected ApplicationController initialValue(){
            return new ApplicationController();
        }
    };
    public ApplicationController getApplicationController(){
        return applicationThreadLocal.get();
    }

    public void remove(){
        applicationThreadLocal.remove();
    }
}
