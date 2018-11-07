package com.ipaynow.yishouyun.goods.provider.controller

import com.ipaynow.yishouyun.goods.provider.entity.GoodsInfo
import com.ipaynow.yishouyun.goods.provider.service.GoodsInfoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
@RequestMapping("/api")
class GoodsController {
    @Resource
    lateinit var goodsInfoService: GoodsInfoService

    @GetMapping("/goods/{goodsId}")
    fun getGoodsIdById(@PathVariable goodsId: String): GoodsInfo {
        return goodsInfoService.findById(goodsId)
    }

    @GetMapping("/stores/{storeId}/goods")
    fun getGoodsListByStoreId(@PathVariable storeId: String): List<GoodsInfo> {
        return goodsInfoService.findByStoreId(storeId)
    }

    @GetMapping("/stores/{storeId}/categories/{categoryId}/goods")
    fun getGoodsListByCategoryId(@PathVariable storeId: String, @PathVariable categoryId: Long): List<GoodsInfo> {
        return goodsInfoService.findByCategoryId(storeId, categoryId)
    }
}