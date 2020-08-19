package com.petto.posting.controller.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petto.posting.exceptions.UnprocessableEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.json.JsonMergePatch;
import javax.json.JsonPatch;
import javax.json.JsonStructure;
import javax.json.JsonValue;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class PatchHelper {

  private final ObjectMapper objectMapper;

  private final Validator validator;

  public <T> T patch(JsonPatch patch, T targetBean, Class<T> beanClass) {
    JsonStructure target = objectMapper.convertValue(targetBean, JsonStructure.class);
    JsonValue patched = applyPatch(patch, target);
    return convertAndValidate(patched, beanClass);
  }

  public <T> T mergePatch(JsonMergePatch mergePatch, T targetBean, Class<T> beanClass) {
    JsonValue target = objectMapper.convertValue(targetBean, JsonValue.class);
    JsonValue patched = applyMergePatch(mergePatch, target);
    return convertAndValidate(patched, beanClass);
  }

  private JsonValue applyPatch(JsonPatch patch, JsonStructure target) {
    try {
      return patch.apply(target);
    } catch (Exception e) {
      throw new UnprocessableEntityException(e);
    }
  }

  private JsonValue applyMergePatch(JsonMergePatch mergePatch, JsonValue target) {
    try {
      return mergePatch.apply(target);
    } catch (Exception e) {
      throw new UnprocessableEntityException(e);
    }
  }

  private <T> T convertAndValidate(JsonValue jsonValue, Class<T> beanClass) {
    T bean = objectMapper.convertValue(jsonValue, beanClass);
    validate(bean);
    return bean;
  }

  private <T> void validate(T bean) {
    Set<ConstraintViolation<T>> violations = validator.validate(bean);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
  }
}
