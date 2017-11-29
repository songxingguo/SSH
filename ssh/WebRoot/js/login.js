/**
 * Created by songxingguo on 2017/10/31.
 */
angular.module("loginModule", ['ngMessages'])
	.controller('loginController', function($scope) {
		
		/**
		 * 改变表单状态
		 */
		$scope.changeState = function (id, state) {
			if (state) {
				$('#' + id).removeClass("has-success");
				$('#' + id).addClass("has-error");
				$scope.addTip(id, 'glyphicon-ok', 'glyphicon-remove');
			} else {
				$('#' + id).removeClass("has-error");
				$('#' + id).addClass("has-success");
				$scope.addTip(id, 'glyphicon-remove', 'glyphicon-ok');
			}
		}
		
		/**
		 * 添加提示
		 */ 
		$scope.addTip= function(id, preClassName, className) {
			$('#' + id).append("<span id='state" + id + "' class='glyphicon" +
					" form-control-feedback'></span> ");
			$('#state' + id).removeClass(preClassName);
			$('#state' + id).addClass(className);
		}
    });

