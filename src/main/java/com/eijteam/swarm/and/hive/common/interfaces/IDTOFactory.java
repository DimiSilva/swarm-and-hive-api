package com.eijteam.swarm.and.hive.common.interfaces;

public interface IDTOFactory<Entity, Req, Res> {
    Res createResDTO(Entity entity);
    Entity reqDTOToEntity(Req dto);
}
