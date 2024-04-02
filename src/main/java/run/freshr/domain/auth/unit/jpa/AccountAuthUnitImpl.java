package run.freshr.domain.auth.unit.jpa;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import run.freshr.common.annotations.Unit;
import run.freshr.domain.account.entity.Account;
import run.freshr.domain.auth.repository.jpa.AccountAuthRepository;

@Slf4j
@Unit
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountAuthUnitImpl implements AccountAuthUnit {

  private final AccountAuthRepository repository;

  @Override
  @Transactional
  public String create(Account entity) {
    return repository.save(entity).getId();
  }

  @Override
  public Boolean exists(String id) {
    return repository.existsById(id);
  }

  /**
   * 데이터 존재 여부 by Username
   *
   * @param username username
   * @return boolean
   * @apiNote 데이터 존재 여부 by Username
   * @author FreshR
   * @since 2024. 3. 28. 오후 5:15:13
   */
  @Override
  public Boolean existsByUsername(String username) {
    return repository.existsByUsername(username);
  }

  @Override
  public Account get(String id) {
    return repository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  /**
   * 데이터 조회 by Username
   *
   * @param username username
   * @return by username
   * @apiNote 데이터 조회 by Username
   * @author FreshR
   * @since 2024. 3. 28. 오후 5:15:13
   */
  @Override
  public Account getByUsername(String username) {
    return repository.findByUsername(username);
  }

}
