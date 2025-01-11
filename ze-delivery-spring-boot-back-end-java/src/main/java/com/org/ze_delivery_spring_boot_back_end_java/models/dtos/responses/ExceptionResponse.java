package com.org.ze_delivery_spring_boot_back_end_java.models.dtos.responses;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
	@JsonFormat(pattern = "yyyy-MM-dd HH:ss")
	private LocalDateTime localDateTime;
	private Integer status;
	private String message;
	private String path;
}