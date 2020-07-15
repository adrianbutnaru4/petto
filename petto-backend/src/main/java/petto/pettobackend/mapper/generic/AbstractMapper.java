package petto.pettobackend.mapper.generic;

public interface AbstractMapper<D, DTO> {

  D mapToDocument(DTO dto);

  DTO mapToDto(D document);
}
