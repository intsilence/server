package org.domeos.api.controller.global;

import com.fasterxml.jackson.databind.DeserializationFeature;
import org.apache.shiro.util.ThreadContext;
import org.domeos.framework.api.model.global.ClusterMonitor;
import org.domeos.base.BaseTestCase;
import org.domeos.basemodel.ResultStat;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.FileInputStream;
import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by feiliu206363 on 2016/1/5.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClusterMonitorControllerTest extends BaseTestCase {
    ClusterMonitor clusterMonitor;
    String clusterMonitorStr;

    @Before
    public void setup() throws IOException {
        ThreadContext.bind(securityManager);

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        FileInputStream fileInputStream = new FileInputStream("./src/test/resources/global/clusterMonitor.json");
        byte[] buff = new byte[fileInputStream.available()];
        fileInputStream.read(buff);
        clusterMonitor = objectMapper.readValue(buff, ClusterMonitor.class);
        clusterMonitorStr = new String(buff);
        this.mockMvc = webAppContextSetup(this.wac).build();
        login("admin","admin");
    }

    @Test
    public void T010Set() throws Exception {
        mockMvc.perform(post("/api/global/monitor").contentType(MediaType.APPLICATION_JSON).content(clusterMonitorStr))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void T020Get() throws Exception {
        mockMvc.perform(get("/api/global/monitor"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.resultCode").value(ResultStat.OK.responseCode))
                .andExpect(status().isOk());
    }

    @Test
    public void T030Put() throws Exception {
        mockMvc.perform(put("/api/global/monitor").contentType(MediaType.APPLICATION_JSON).content(clusterMonitorStr))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.resultCode").value(ResultStat.OK.responseCode))
                .andExpect(status().isOk());
    }

    @Test
    public void T040Delete() throws Exception {
        mockMvc.perform(delete("/api/global/monitor"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.resultCode").value(ResultStat.OK.responseCode))
                .andExpect(status().isOk());
    }
}
