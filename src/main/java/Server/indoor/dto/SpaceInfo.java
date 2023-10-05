package Server.indoor.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SpaceInfo {

    public SpaceInfo(String pos_name, float x1, float x2, float z1, float z2) {
        this.pos_name = pos_name;
        this.x1 = x1;
        this.x2 = x2;
        this.z1 = z1;
        this.z2 = z2;
    }

    private String pos_name;
    private float x1;
    private float x2;
    private float z1;
    private float z2;
}
