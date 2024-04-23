package com.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class JWTDecoder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the JWT token: ");
        String jwtToken = sc.next();


        try {
            /*
             * JWT Token 1 :  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjM0IiwiYXVkIjpbImFkbWluIl0sImlzcyI6Im1hc29uLm1ldGFtdWcubmV0IiwiZXhwIjoxNTc0NTEyNzY1LCJpYXQiOjE1NjY3MzY3NjUsImp0aSI6ImY3YmZlMzNmLTdiZjctNGViNC04ZTU5LTk5MTc5OWI1ZWI4YSJ9.EVcCaSqrSNVs3cWdLt-qkoqUk7rPHEOsDHS8yejwxMw
             * JWT Token 2 :  eyJhbGciOiJSUzI1NiJ9.eyJ1c2VybmFtZSI6Ik1DaGFtYmU0IiwiZXhwIjoxNDU2OTEwODgzLCJzY29wZSI6WyJvcGVuaWQiLCJwMnAiLCJociIsImRhcyIsIm1lIl0sImNsaWVudF9pZCI6Im1vYmlsZSIsImp0aSI6ImNZcHBMYXltVzlmNXFBZk4ifQ.QqZI9vV8IznTjN-GtUSCri9-6HH6Yl1Oae6K8-d2yjQ4fysF5d3wStdL2kMazl7xeqbtSIsw-F5Aol9eHdGAu54b9IyBEM_QIasy0lnT8xFk0Zi36NJ-7yhl_89f6SB6TGimM59xUvzXxuAw3FzWM6TbiptInrCL2TXkhS69Gng-ANPeiSITUX5A1TDInssds6ZoSb7IOUMtxPGfrbO9sBjx8aJlIu9igkqk4OX5xBmxLp3icoo98I5v9Wt_Huu7eWKBfOskMSEav4X_m5_phbAZJ_F8nWRmcxk6O7hCQdawzegnhMxP2IPIhwlWRNX_8WxkNErq2fJgdazDf8pS_Q
             * JWT Token 3 :  eyJhbGciOiJSUzUxMiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJzWjJ4TXZhYnNkdmlpNUtFdWJhQnR0NTRaeTloYTk3MTRTN1ZBWl90TEJVIn0.eyJleHAiOjE3MDg1MTA4MTYsImlhdCI6MTcwODUwNzIxNiwianRpIjoiNzIzZTYzYmItOWNmMi00N2IwLWJmYTMtY2M0MjY4OTFiMzZiIiwiaXNzIjoiaHR0cHM6Ly96em8tdWF0LnRydWUudGgvYXV0aC9yZWFsbXMvRW1wbG95ZWUtSW50cmFuZXQiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiZDc2NWZmZmMtMWIxZS00OWE3LTg0MzktMDZkN2M4NWIyN2IxIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiYmRoLXVhdDEtZW1wbG95ZWUiLCJzZXNzaW9uX3N0YXRlIjoiMmFjMzdjZDUtOWIyOC00NTZjLThkNGItODcwZDQ4ZWE3MWRhIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyIvKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtZW1wbG95ZWUtaW50cmFuZXQiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6InByb2ZpbGUgZW1haWwiLCJzaWQiOiIyYWMzN2NkNS05YjI4LTQ1NmMtOGQ0Yi04NzBkNDhlYTcxZGEiLCJJTklUSUFMUyI6Ii0iLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsIkVNUExPWUVFSUQiOiIwMTA4MTQyNyIsIkVOR0xJU0hOQU1FIjoiVS1TVkMtYmRodWF0IiwiRklSU1ROQU1FIjoiVS1TVkMtYmRodWF0IiwiU0FMRV9DT0RFIjoiLSIsImdpdmVuX25hbWUiOiJVLVNWQy1iZGh1YXQiLCJDT01QQU5ZIjoiVFVDIiwiUE9TSVRJT04iOiItIiwiTUFJTCI6Ii0iLCJST0xFUyI6WyJDTj1SLUNFUy1SMS1HZXRVc2FnZUNvbnN1bXB0aW9uUmVwb3J0LE9VPUNFUyxPVT1Hcm91cCxEQz1zc29hZGR2LERDPXRoIiwiQ049Ui1DRVMtUjEtR2V0VXNhZ2VMaXN0LE9VPUNFUyxPVT1Hcm91cCxEQz1zc29hZGR2LERDPXRoIl0sIm5hbWUiOiJVLVNWQy1iZGh1YXQiLCJTSE9QQ09ERSI6IsOvwrvCvy0iLCJMT0dJTk5BTUUiOiJiZGh1YXQiLCJlbWFpbCI6Ii0iLCJTRUNUSU9OIjoiLSIsInVzZXJuYW1lIjoiYmRodWF0IiwiQ0hBTk5FTF9BTElBUyI6Ii0ifQ.PunOBwciA-tzkaDfiPb26mThDFU78Li3HKVe82K8nPWX9LxB6JfVuAEWXn4SDCY8Y2eSDXswd71RcXiEPh-rwWbZdWzptvRGfpUzoHFSPnM6nssoxHZ8FMCvgc4wwtUMkbeAyXdMe5shnVDGytLWSaVjpb66CkUxi9efJeVOBXzlcSq1aAJCDBMI43Y8-rccY2wzSzWqDh1VP9W1RvLT21pioaJ9E1FJ7nHlC_383309wZnkWFF74DowRNHDBg7LFCJf_5qQDs8ytazy1swEWExowop-pgSgSOHbvv_uZY2TKETXpMQ51hLtpRa2AOqd68Xw-CDEsDIdcu1StOpKhw
             */

            /*
             * Split the JWT into its three parts
             */
            String[] jwtParts = jwtToken.split("\\.");

            /*
             * Decode and print the Header
             */
            String header = decodeBase64(jwtParts[0]);
            System.out.println("Header: " + header);

            /*
             * Decode and print the Payload
             */
            String payload = decodeBase64(jwtParts[1]);
            System.out.println("Payload: " + payload);

            /*
             * Decode and print the Signature
             */
            String signature = decodeBase64(jwtParts[2]);
            System.out.println("Signature: "+signature);

        } catch (Exception e) {

            /*
             * Handle exceptions
             */
            System.out.println("Exception is " + e);
        }
    }

    private static String decodeBase64(String base64String) {
        byte[] decodedBytes = Base64.getUrlDecoder().decode(base64String);
        /*
         * The byte array represents the decoded data which is
         * then converted into String data using UTF-8 encoding
         */
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
}
