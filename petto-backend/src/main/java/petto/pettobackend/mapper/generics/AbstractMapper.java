package petto.pettobackend.mapper.generics;

public interface AbstractMapper<D, DTO> {

  D mapToDocument(DTO dto);

  DTO mapToDto(D document);
}
