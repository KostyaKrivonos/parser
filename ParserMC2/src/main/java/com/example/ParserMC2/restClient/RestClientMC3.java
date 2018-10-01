package com.example.ParserMC2.restClient;

import com.example.ParserMC2.dto.dtoMC3.RequestDTOmc3;
import com.example.ParserMC2.dto.dtoMC3.ResponseDTOmc3;
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
public class RestClientMC3 {
 String urlPostMC3 = "http://188.166.32.62:9080/separation";
 Logger logger = LoggerFactory.getLogger(RestClientMC3.class);

 public ResponseDTOmc3 postMC3 (int idExplorer){
     RequestDTOmc3 requestDTOmc3 = new RequestDTOmc3();
     requestDTOmc3.setIdExplorer(idExplorer);

     try (CloseableHttpClient client = HttpClients.createDefault();){
         HttpPost httpPost = new HttpPost(urlPostMC3);

         ObjectMapper objectMapper = new ObjectMapper();
         String value = objectMapper.writeValueAsString(requestDTOmc3);
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
