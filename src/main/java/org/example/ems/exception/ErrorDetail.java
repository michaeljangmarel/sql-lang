package org.example.ems.exception;

import java.time.LocalDateTime;

public record ErrorDetail (      String message,
          LocalDateTime time,
          String details ,
           String code){


}
