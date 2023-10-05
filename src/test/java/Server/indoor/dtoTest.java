package Server.indoor;

import Server.indoor.dto.SpaceInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class dtoTest {

    @Test()
    public void dtoTESTs() {
        List<SpaceInfo> list = new LinkedList<>();

        list.add(new SpaceInfo("구역 1", -1.54f, 2.96f, -6.86f, -1.39f));
        list.add(new SpaceInfo("구역 2", -1.54f, 2.96f, -6.86f, -1.39f));
        list.add(new SpaceInfo("구역 3", -1.54f, 2.96f, -6.86f, -1.39f));

        Map<String, Object> data = new HashMap<>();
        data.put("spaceInfo", list);

        try {
            String json;
            json = new ObjectMapper().writeValueAsString(data);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
