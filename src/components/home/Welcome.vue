<template>
		<div>
			<div class="block">
			<span class="demonstration">选择年份查询:</span>
			<el-date-picker
			  v-model="years"
			  type="year"
			  align="right"
			  placeholder="选择年"
			  @change="fn()"
			  value-format="yyyy">
			</el-date-picker>
		</div>
		<h1>企业能耗比对比图</h1>
		<ve-line :data="chartData"></ve-line>
		<h1>企业作业量对比图(单位：万吨)</h1>
		<ve-histogram :data="chartData2"></ve-histogram>
		<h1>设备作业量对比图</h1>
		<ve-pie :data="chartData3"></ve-pie>
	</div>
</template>

<script>
	export default {
		name:'',
		data() {
			return {
				chartData: {
				  columns: [],
				  rows: [] ,
				},
				chartData2: {
				  columns: [],
				  rows: []
				},
				chartData3: {
				  columns: [],
				  rows: []
				},years:"2018"
			};
		},
		methods:{
			chartDatas(){
				// 后端网址
				var url = this.baseUrl+"/jobAmount/flowAmount"
				// 传递给后端的数据
				var data = {year:this.years};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					this.chartData=res.data
				})
			},chartData2s(){
				var url = this.baseUrl+"/jobAmount/devTypeAmount"
				// 传递给后端的数据
				var data = {year:this.years};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					this.chartData2=res.data
				})
			},chartData3s(){
				var url = this.baseUrl+"/jobAmount/devAmount"
				// 传递给后端的数据
				var data = {year:this.years};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					this.chartData3=res.data
				})
			},
			fn(){
				this.chartDatas();
				this.chartData2s();
				this.chartData3s();
			}
		},mounted:function () {
			this.fn();
			
		}
		
	}
</script>

<style>
h1{
	text-align: center;
}
</style>
