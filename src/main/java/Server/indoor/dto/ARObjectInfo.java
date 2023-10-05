package Server.indoor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ARObjectInfo {

    public ARObjectInfo(String file_name, String direction, float x, float y, float z) {
        this.file_name = file_name;
        this.direction = direction;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private String file_name;
    private String direction;
    private float x;
    private float y;
    private float z;
}
