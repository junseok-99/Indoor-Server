package Server.indoor.repository;

import Server.indoor.dto.ARObjectInfo;
import Server.indoor.dto.SpaceInfo;

import java.util.List;

public interface MyRepository {

    List<SpaceInfo> findSpace(String spaceName);
}
