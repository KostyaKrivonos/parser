package com.example.ParserMC1.restClient;

import com.example.ParserMC1.dto.ResponseDTO;
import com.example.ParserMC1.dto.dtoMC2.RequestDTOmc2;
import com.example.ParserMC1.dto.dtoMC2.ResponseDTOmc2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Component
public class RestClientMC2 {
 String urlPostMC2 = "http://188.166.32.62:8090/description";
 Logger logger = LoggerFactory.getLogger(RestClientMC2.class);

 public ResponseDTOmc2 postMC2 (int idExplorer){
     RequestDTOmc2 requestDTOmc2 = new RequestDTOmc2();
     requestDTOmc2.setIdExplorer(idExplorer);

     try (CloseableHttpClient client = HttpClients.createDefault();){
         HttpPost httpPost = new HttpPost(urlPostMC2);

         ObjectMapper objectMapper = new ObjectMapper();
         String value = objectMapper.writeValueAsString(requestDTOmc2);
         StringEntity stringEntity = new StringEntity(value);

         httpPost.setEntity(stringEntity);
         httpPost.setHeader("Accept", "application/json");
         httpPost.setHeader("Content-type", "application/json");

         CloseableHttpResponse response = client.execute(httpPost);
         logger.error(response.getStatusLine().toString());
         logger.error(EntityUtils.toString(response.getEntity()));


     } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
     } catch (JsonProcessingException e) {
         e.printStackTrace();
     } catch (ClientProtocolException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }
     return null;
 }

}
