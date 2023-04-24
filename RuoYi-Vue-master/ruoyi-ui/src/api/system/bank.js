import request from '@/utils/request'

// 查询课程库列表
export function listBank(query) {
  return request({
    url: '/system/bank/list',
    method: 'get',
    params: query
  })
}

// 查询课程库详细
export function getBank(id) {
  return request({
    url: '/system/bank/' + id,
    method: 'get'
  })
}

// 新增课程库
export function addBank(data) {
  return request({
    url: '/system/bank',
    method: 'post',
    data: data
  })
}

// 修改课程库
export function updateBank(data) {
  return request({
    url: '/system/bank',
    method: 'put',
    data: data
  })
}

// 删除课程库
export function delBank(id) {
  return request({
    url: '/system/bank/' + id,
    method: 'delete'
  })
}
