package com.azbj.fm2002.util;

public class AlertListValidationUtil {

    public static boolean validateOptions(Options options) {
        return isValidOption(options.getBackdating()) &&
               isValidOption(options.getDispatch()) &&
               isValidOption(options.getReceipt()) &&
               isValidOption(options.getPremium()) &&
               isValidOption(options.getRider()) &&
               isValidOption(options.getExcessPremium()) &&
               isValidOption(options.getMobile());
    }

    private static boolean isValidOption(String option) {
        return "N".equals(option) || "Y".equals(option);
    }

    public static class Options {
        private String backdating;
        private String dispatch;
        private String receipt;
        private String premium;
        private String rider;
        private String excessPremium;
        private String mobile;

        // Getters and Setters
        public String getBackdating() {
            return backdating;
        }

        public void setBackdating(String backdating) {
            this.backdating = backdating;
        }

        public String getDispatch() {
            return dispatch;
        }

        public void setDispatch(String dispatch) {
            this.dispatch = dispatch;
        }

        public String getReceipt() {
            return receipt;
        }

        public void setReceipt(String receipt) {
            this.receipt = receipt;
        }

        public String getPremium() {
            return premium;
        }

        public void setPremium(String premium) {
            this.premium = premium;
        }

        public String getRider() {
            return rider;
        }

        public void setRider(String rider) {
            this.rider = rider;
        }

        public String getExcessPremium() {
            return excessPremium;
        }

        public void setExcessPremium(String excessPremium) {
            this.excessPremium = excessPremium;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }
}