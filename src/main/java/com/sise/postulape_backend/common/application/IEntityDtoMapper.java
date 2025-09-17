package com.sise.postulape_backend.common.application;

public interface IEntityDtoMapper<Entity, RequestDto, ResponseDto> {
    
    public Entity requestToEntity(RequestDto requestDto);
    public ResponseDto entityToResponse(Entity entity);

}
