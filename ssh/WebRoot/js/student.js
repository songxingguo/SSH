/**
 * Created by songxingguo on 2017/11/7.
 */
angular.module("studentModule", ['ngMessages'])
	.controller('studentController', function($scope, $http) {
		
		//根据属性改变条件
		($scope.gradeChange = function(proName) {
			if (proName=="stuAge") {
				$("#operate").html("<option value='>'>大于</option> " +
						"<option value='>='>大于等于</option> " +
						"<option value='='>等于</option> " +
						"<option value='<='>小于等于</option> " +
						"<option value='<'>小于</option> ");
			} else {
				$("#operate").html("<option value='%'>包含</option> " +
						"<option value='='>等于</option>");
			}
		})();
		
		//根据Id查询学生
		$scope.stu = {};
		$scope.getStudent = function() {
			$.post('stu.action',{'id':id},function(data){
				$scope.stu = data.stuDTO;
				alert($scope.stu);
			},"json");
		}
		
		$scope.getClas = function() {
			$http({
		        method: 'GET',
		        url: '/ssh/clas.action'
		    }).success(function(data,status,headers,config) {
		        alert(data.stuDTO);
		    }).error(function(data,status,headers,config) {
		        // 当响应以错误状态返回时调用
		    });
		}
		
//		($scope.init = function() {
//			var limit = 2, showCount = 1, totalCount = 3;
//	        $('#callBackPager').extendPagination({
//
//	            totalCount: totalCount,
//
//	            showCount: showCount,
//
//	            limit: limit,
//
//	            callback: function (curr, limit, totalCount) {
//	            	window.location.href= "stus.action?first=" + curr;
//	            }
//	        });
//		})();
    });