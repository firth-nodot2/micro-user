package org.rhydo.microuser.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
  String resourceName;
  String fieldName;
  String fieldId;

  public ResourceNotFoundException(String resourceName, String fieldName, String fieldId) {
    super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldId));
    this.resourceName = resourceName;
    this.fieldName = fieldName;
    this.fieldId = fieldId;
  }

}
