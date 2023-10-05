package Server.indoor.repository;

import Server.indoor.dto.SpaceInfo;

import java.util.List;

public interface MyRepository {

    String findId(String id);
    List<SpaceInfo> findSpace(String spaceName);
}
