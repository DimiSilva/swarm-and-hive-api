package com.eijteam.swarm.and.hive.common.interfaces;

public interface IResDTOFactory<Entity, Res> {
    Res createResDTO(Entity entity);
}
