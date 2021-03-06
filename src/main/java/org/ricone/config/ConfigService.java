package org.ricone.config;

import org.apache.commons.lang3.StringUtils;
import org.ricone.api.core.request.info.model.Config;
import org.ricone.config.model.*;
import org.ricone.error.exception.ConfigException;
import org.ricone.init.ConfigProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component
public class ConfigService {
    private static ConfigService instance = null;
    private Credential credential = initializeCredential();
    private String url = null;
    private String username = null;
    private String password = null;

    public static ConfigService getInstance() {
        if(instance == null) {
            instance = new ConfigService();
        }
        return instance;
    }

    private Credential getCredential() {
        return credential;
    }

    private void setCredential(Credential credential) {
        this.credential = credential;
    }

    public Credential initializeCredential() {
        try {
            Login l = new Login(getUsername(), getPassword());
            RestTemplate rt = new RestTemplate();
            Credential credential = rt.postForObject(getUrl() + "/Users/login", l, Credential.class);
            setCredential(credential);
            return credential;
        }
        catch (Exception e) {
            return null;
        }
    }

    /*********** Login ***********/
    String getAccessToken() throws RestClientException {
        try {
            // If Null or Expired
            if(getCredential() == null || (ISO8601toLong(this.getCredential().getCreated()) + (1000 * this.getCredential().getTtl())) <= System.currentTimeMillis()) {
                Login l = new Login(getUsername(), getPassword());
                RestTemplate rt = new RestTemplate();
                Credential credential = rt.postForObject(getUrl() + "/Users/login", l, Credential.class);
                setCredential(credential);
                return credential.getId();
            }
            else {
                return getCredential().getId();
            }
        }
        catch (Exception e) {
            return null;
        }
    }

    /*********** Config Status ***********/
    public Config getConfigStatus() {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.set("Authorization", this.getAccessToken());
            HttpEntity<?> entity = new HttpEntity<Object>(headers);
            String rootUrl = getUrl().replace("/api", "");

            ResponseEntity<Config> response = rt.exchange((rootUrl), HttpMethod.GET, entity, Config.class);

            if(StringUtils.isNotBlank(response.getBody().getStarted())) {
                response.getBody().setStatus("Up");
            }
            return response.getBody();
        }
        catch (Exception e) {
            return new Config("Down");
        }
    }

    public Profile[] getProfiles() {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.set("Authorization", getAccessToken());
            HttpEntity<?> entity = new HttpEntity<Object>(headers);
            ResponseEntity<Profile[]> response = rt.exchange((getUrl() + "/profile"), HttpMethod.GET, entity, Profile[].class);
            return response.getBody();
        }
        catch (Exception e) {
        }
        return null;
    }

    public Profile getProfileByAppId(String appId) {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.set("Authorization", getAccessToken());
            HttpEntity<?> entity = new HttpEntity<Object>(headers);
            ResponseEntity<Profile> response = rt.exchange((getUrl() + "/app/" + appId + "/profile"), HttpMethod.GET, entity, Profile.class);
            return response.getBody();
        }
        catch (Exception e) {
        }
        return null;
    }


    public App[] getApps() {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.set("Authorization", getAccessToken());
            HttpEntity<?> entity = new HttpEntity<Object>(headers);
            ResponseEntity<App[]> response = rt.exchange((getUrl() + "/app"), HttpMethod.GET, entity, App[].class);
            return response.getBody();
        }
        catch (Exception e) {
        }
        return null;
    }

    public App getApp(String appId) {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.set("Authorization", getAccessToken());
            HttpEntity<?> entity = new HttpEntity<Object>(headers);
            ResponseEntity<App> response = rt.exchange((getUrl() + "/app/" + appId), HttpMethod.GET, entity, App.class);
            return response.getBody();
        }
        catch (Exception e) {
        }
        return null;
    }

    public Provider getProvider(String providerId) {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.set("Authorization", getAccessToken());
            HttpEntity<?> entity = new HttpEntity<Object>(headers);
            ResponseEntity<Provider> response = rt.exchange((getUrl() + "/provider/" + providerId), HttpMethod.GET, entity, Provider.class);
            return response.getBody();
        }
        catch (Exception e) {
        }
        return null;
    }

    public HashMap<String, String> getProviderAPIKV(String providerId) {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.set("Authorization", getAccessToken());
            HttpEntity<?> entity = new HttpEntity<Object>(headers);
            ResponseEntity<ProviderKV[]> response = rt.exchange((getUrl() + "/provider/" + providerId + "/apikv"), HttpMethod.GET, entity, ProviderKV[].class);

            HashMap<String, String> infoMap = new HashMap<String, String>();

            for (ProviderKV info : response.getBody()) {
                infoMap.put(info.getField(), info.getValue());
            }
            return infoMap;
        }
        catch (Exception e) {
        }
        return null;
    }

    public HashMap<String, String> getDistrictAPIKV(String districtId) throws RestClientException {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.set("Authorization", getAccessToken());
            HttpEntity<?> entity = new HttpEntity<Object>(headers);
            ResponseEntity<DistrictKV[]> response = rt.exchange((getUrl() + "/district/" + districtId + "/apikv"), HttpMethod.GET, entity, DistrictKV[].class);

            HashMap<String, String> infoMap = new HashMap<String, String>();

            for (DistrictKV info : response.getBody()) {
                infoMap.put(info.getField(), info.getValue());
            }
            return infoMap;
        }
        catch (Exception e) {
        }
        return null;
    }

    public List<District> getDistrictsByApp(String appId) {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<List<District>> response;
        try {
            headers.set("Authorization", getAccessToken());
            HttpEntity<?> entity = new HttpEntity<Object>(headers);
            response = rt.exchange((getUrl() + "/app/" + appId + "/district"), HttpMethod.GET, entity, new ParameterizedTypeReference<List<District>>() {
            });
            return response.getBody();
        }
        catch (ConfigException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long ISO8601toLong(String iso) {
        ZonedDateTime date = ZonedDateTime.parse(iso); // works
        return date.toInstant().toEpochMilli();
    }

    @SuppressWarnings("unused")
    private static Date LongToISO8601(long t) {
        return new Date(t);
    }

    public String getUrl() throws ConfigException {
        if(url == null) {
            url = ConfigProperties.getInstance().getProperty("component.config.href");
        }
        return url;
    }

    public String getUsername() throws ConfigException {
        if(username == null) {
            username = ConfigProperties.getInstance().getProperty("component.config.username");
        }
        return username;
    }

    public String getPassword() throws ConfigException {
        if(password == null) {
            password = ConfigProperties.getInstance().getProperty("component.config.password");
        }
        return password;
    }

}
