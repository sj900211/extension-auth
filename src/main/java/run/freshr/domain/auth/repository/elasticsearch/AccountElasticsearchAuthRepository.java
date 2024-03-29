package run.freshr.domain.auth.repository.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import run.freshr.domain.account.entity.Account;

/**
 * 사용자 계정 정보 관리 권한 elasticsearch repository
 *
 * @author FreshR
 * @apiNote 사용자 계정 정보 관리 권한 elasticsearch repository<br>
 *          Micro 서비스와 달리 권한 처리 서비스에서 사용할 목적으로 생성<br>
 *          실제 서비스와 중복되는 기능이 있지만 권한 처리 서비스와 같이 독특한 케이스의 경우 중복 기능을 허용
 * @since 2024. 3. 28. 오후 4:54:23
 */
public interface AccountElasticsearchAuthRepository extends 
    ElasticsearchRepository<Account, String> {

}
