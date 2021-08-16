package com.ming.demo.java8;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Ming
 * @date 2021/7/15 10:34
 * @description
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class TeamUserEntity {
	private Long teamId;

	private Long userId;

	private Integer leaderFlag;

	private Integer playFlag;

	private String formatDate;

}
