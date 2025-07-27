package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.goods;
import generator.mapper.goodsMapper;
import generator.service.goodsService;
import org.springframework.stereotype.Service;

/**
* @author hua
* @description 针对表【goods(物品表)】的数据库操作Service实现
* @createDate 2025-07-24 21:37:39
*/
@Service
public class goodsServiceImpl extends ServiceImpl<goodsMapper, goods>
    implements goodsService{

}




