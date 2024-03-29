package run.freshr.domain.auth.unit.jpa;

import run.freshr.common.extensions.unit.UnitDefaultExtension;
import run.freshr.domain.account.entity.Account;

/**
 * 사용자 계정 정보 관리 unit
 *
 * @author FreshR
 * @apiNote 사용자 계정 정보 관리 unit
 * @since 2024. 3. 28. 오후 4:54:23
 */
public interface AccountAuthUnit extends UnitDefaultExtension<Account, String> {

  /**
   * 데이터 존재 여부 by Username
   *
   * @param username username
   * @return boolean
   * @apiNote 데이터 존재 여부 by Username
   * @author FreshR
   * @since 2024. 3. 28. 오후 5:15:13
   */
  Boolean existsByUsername(String username);

  /**
   * 데이터 조회 by Username
   *
   * @param username username
   * @return by username
   * @apiNote 데이터 조회 by Username
   * @author FreshR
   * @since 2024. 3. 28. 오후 5:15:13
   */
  Account getByUsername(String username);

}
