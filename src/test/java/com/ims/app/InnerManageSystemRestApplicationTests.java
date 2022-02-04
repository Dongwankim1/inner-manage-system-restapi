package com.ims.app;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InnerManageSystemRestApplicationTests {
	
	@Test
	void contextLoads() {
		
		String url = "localhost:3306/ims";
        String username = "ims";
        String password = "ims12!@";

        System.out.println(jasyptEncoding(url));
        System.out.println(jasyptEncoding(username));
        System.out.println(jasyptEncoding(password));
	}
	
	
	public String jasyptEncoding(String value) {

        String key = "my_name_dizzy";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }
}
