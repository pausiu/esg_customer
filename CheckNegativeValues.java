package com.esg.util;
public class CheckNegativeValues {
    public static class NegativesNotAllowedException extends RuntimeException {
        public NegativesNotAllowedException(String str) {
            super(str);
        }
    }

    public static void throwExceptionIfNegativeExist(String negativeNoStr) {
        if (negativeNoStr != "") {
            throw new NegativesNotAllowedException("Negatives not allowed: " + negativeNoStr);
        }
    }

}