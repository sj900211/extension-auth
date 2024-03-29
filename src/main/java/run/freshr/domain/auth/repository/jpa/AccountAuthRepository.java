package run.freshr.domain.auth.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import run.freshr.domain.account.entity.Account;

/**
 * 사용자 계정 정보 관리 권한 repository
 *
 * @author FreshR
 * @apiNote 사용자 계정 정보 관리 권한 repository<br>
 *          Micro 서비스와 달리 권한 처리 서비스에서 사용할 목적으로 생성<br>
 *          실제 서비스와 중복되는 기능이 있지만 권한 처리 서비스와 같이 독특한 케이스의 경우 중복 기능을 허용
 * @since 2024. 3. 28. 오후 4:54:23
 */
public interface AccountAuthRepository extends JpaRepository<Account, String> {

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
  Account findByUsername(String username);

}
