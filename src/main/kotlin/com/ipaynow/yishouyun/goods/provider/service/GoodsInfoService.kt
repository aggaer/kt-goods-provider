package com.ipaynow.yishouyun.goods.provider.service

import com.ipaynow.yishouyun.goods.provider.entity.GoodsInfo
import com.ipaynow.yishouyun.goods.provider.repository.GoodsInfoRepository
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class GoodsInfoService {
    @Resource
    private lateinit var goodsInfoRepository: GoodsInfoRepository

    fun findById(goodsId: String): GoodsInfo {
        return goodsInfoRepository.findById(goodsId).orElseThrow { RuntimeException("此id:$goodsId 对应的商品信息不存在") }
    }

    fun findByCategoryId(storeId: String, categoryId: Long): List<GoodsInfo> {
        return goodsInfoRepository.findByStoreIdAndCategoryIdAndStatusGreaterThan(storeId, categoryId, 0)
    }

    fun findByStoreId(storeId: String): List<GoodsInfo> {
        return goodsInfoRepository.findByStoreIdAndStatusGreaterThan(storeId, 0)
    }
}