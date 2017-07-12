package com.havenlife.vision.BaseFramework;

import PageContentObjectModel.InsuranceCalculator;
import com.paxovision.execution.reporter.interceptor.ProxyGenerator;

/**
 * Created by Abdullah on 6/25/17.
 */
public class ApplicationController {

    private InsuranceCalculator insuranceCalculator;

    public ApplicationController() {

    }

    public InsuranceCalculator insuranceCalculator(){
        if(insuranceCalculator==null){
            //homepage = new Homepage();
            insuranceCalculator = ProxyGenerator.getEnhancedObject(InsuranceCalculator.class);
        }
        return insuranceCalculator;
    }
}
