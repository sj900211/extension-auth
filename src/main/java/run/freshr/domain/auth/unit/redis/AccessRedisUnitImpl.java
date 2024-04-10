package run.freshr.domain.auth.unit.redis;

import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import run.freshr.common.annotations.Unit;
import run.freshr.domain.auth.redis.AccessRedis;
import run.freshr.domain.auth.repository.redis.AccessRedisRepository;

@Unit
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccessRedisUnitImpl implements AccessRedisUnit {

  private final AccessRedisRepository repository;
  
  @Override
  @Transactional
  public void save(AccessRedis document) {
    repository.save(document);
  }

  @Override
  public Boolean exists(String id) {
    return repository.existsById(id);
  }

  /**
   * 데이터 존재 여부
   *
   * @param signId 계정 일련 번호
   * @return boolean
   * @apiNote 데이터 존재 여부
   * @author FreshR
   * @since 2024. 3. 28. 오후 4:54:23
   */
  @Override
  public Boolean existsBySignId(String signId) {
    Iterable<AccessRedis> accesses = repository.findAll();
    Optional<AccessRedis> authAccess = StreamSupport.stream(accesses.spliterator(), false)
        .filter(access -> access.getSignId().equals(signId))
        .findFirst();

    return authAccess.isPresent();
  }

  @Override
  public AccessRedis get(String id) {
    return repository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  /**
   * 데이터 조회
   *
   * @param signId 계정 일련 번호
   * @return access redis
   * @apiNote 데이터 조회
   * @author FreshR
   * @since 2024. 3. 28. 오후 4:54:23
   */
  @Override
  public AccessRedis getBySignId(String signId) {
    Iterable<AccessRedis> accesses = repository.findAll();
    Optional<AccessRedis> authAccess = StreamSupport.stream(accesses.spliterator(), false)
        .filter(access -> access.getSignId().equals(signId))
        .findFirst();

    return authAccess.orElseThrow(EntityNotFoundException::new);
  }

  /**
   * 데이터 목록 조회
   *
   * @return list
   * @apiNote 데이터 목록 조회
   * @author FreshR
   * @since 2024. 3. 28. 오후 4:54:23
   */
  @Override
  public Iterable<AccessRedis> getList() {
    return repository.findAll();
  }

  @Override
  @Transactional
  public void delete(String id) {
    repository.deleteById(id);
  }

  /**
   * 삭제
   *
   * @param signId 계정 일련 번호
   * @apiNote 삭제
   * @author FreshR
   * @since 2024. 3. 28. 오후 4:54:23
   */
  @Override
  @Transactional
  public void deleteBySignId(String signId) {
    Iterable<AccessRedis> accesses = repository.findAll();
    Optional<AccessRedis> authAccess = StreamSupport.stream(accesses.spliterator(), false)
        .filter(access -> access.getSignId().equals(signId))
        .findFirst();

    authAccess.ifPresent(repository::delete);
  }
  
}
