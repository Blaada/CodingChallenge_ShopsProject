var postApp = angular.module('postApp', []);
postApp.controller('postController', function($scope, $http, $compile) {

	
	
	
    $scope.closeMsg = function() {
        $scope.alertMsg = false;
    };
    if ($scope.userName != null) {
        $scope.login_form = false;
        $scope.panel_logged = true;
        $scope.register_form = false;
    } else {
        $scope.login_form = true;
        $scope.panel_logged = false;
        $scope.register_form = false;

    }
    $scope.showRegister = function() {
        $scope.login_form = false;
        $scope.register_form = true;
        $scope.alertMsg = false;
    };

    $scope.showLogin = function() {
        $scope.register_form = false;
        $scope.login_form = true;
		$scope.panel_logged = false;
        $scope.alertMsg = false;
    };
	
	$scope.logout = function() {
        $http({
                method: 'post',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded',
                    "Authorization": $scope.TType + " " + $scope.Token
                },
                url: 'http://localhost:9090/user/logout'
            })
            .success(function(data) {
				$scope.register_form = false;
				$scope.login_form = true;
				$scope.panel_logged = false;
                $scope.alertMsg = true;
				$scope = $scope.$new(true);
				
                $scope.alertMessage = data.message;

            })
			.error(function(err) {
				$scope.alertMsg = true;
				
                $scope.alertMessage = err.message;
			});
    };
	
	$scope.likedShop = function(event) {
        $http({
                method: 'post',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded',
                    "Authorization": $scope.TType + " " + $scope.Token
                },
                url: 'http://localhost:9090/interaction/liked',
				data: 'email=' + $scope.userName + '&shop_id=' + event.target.id
            })
            .success(function(data) {

                $scope.alertMsg = true;
                $scope.alertMessage = "Shop liked";

            })
			.error(function(err) {
				$scope.alertMsg = true;
				
                $scope.alertMessage = err.message;
			});
    };
	
	$scope.removeLiked = function(event) {
        $http({
                method: 'post',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded',
                    "Authorization": $scope.TType + " " + $scope.Token
                },
                url: 'http://localhost:9090/interaction/removeLike',
				data: 'email=' + $scope.userName + '&shop_id=' + event.target.id
            })
            .success(function(data) {

                $scope.alertMsg = true;
                $scope.alertMessage = "Like removed";

            })
			.error(function(err) {
				$scope.alertMsg = true;
				
                $scope.alertMessage = err.message;
			});
    };
	
    $scope.submitRegister = function() {

        $http({
                method: 'post',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded'
				},
                url: 'http://localhost:9090/shop/auth/signup',
				data: 'email=' + $scope.registerData.email + '&password=' + $scope.registerData.password
            })
            .success(function(data) {

                $scope.alertMsg = true;
                $scope.alertMessage = data.message;

            })
			.error(function(err) {
				$scope.alertMsg = true;
				
                $scope.alertMessage = err.message;
			});
    };

    $scope.submitLogin = function() {

        $http({
                method: 'post',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded'
				},
                url: 'http://localhost:9090/shop/auth/signin',
				data: 'email=' + $scope.loginData.email + '&password=' + $scope.loginData.password
            })
            .success(function(data) {
                
                $scope.login_form = false;
                $scope.register_form = false;
                $scope.panel_logged = true;
                $scope.userName = data.username;
                $scope.Token = data.token;
                $scope.TType = data.type;
				
				if (navigator.geolocation) {
					navigator.geolocation.getCurrentPosition(function(position) {
					$scope.$apply(function() {
				
					$scope.latitude = position.coords.latitude;
					$scope.longitude = position.coords.longitude;
				
			
            });
        });
    }

            })
			.error(function(err) {
				
				$scope.alertMsg = true;
                $scope.alertMessage = "Error : "+ err.error;
			});
    };
	/* list of shops sorted by distance */
    $scope.listShop = function() {
		/* Get current user location */ 
    
	if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            $scope.$apply(function() {
				
                $scope.latitude = position.coords.latitude;
				$scope.longitude = position.coords.longitude;
				
			
            });
        });
    }
	/* Get current user location */ 
	
	
	
	/* Get the list of shops sorted by distance between client and shops*/
	 $http({
                method: 'post',
                headers: {
					'Content-Type': 'application/x-www-form-urlencoded',
                    "Authorization": $scope.TType + " " + $scope.Token
                },
                url: 'http://localhost:9090/list/shop/all',
				data: 'latitude_Client='+$scope.latitude+'&longitude_Client='+$scope.longitude+'&email='+$scope.userName
            })
            .success(function(data) {
				var htmlContainer = "";
				
				
				for(var i=0;i<data.length;i++){
					htmlContainer += "<div class='col-md-3 col-sm-6'><div class='product-grid'><div class='product-image'> <a href='#'>"+
                        "<img class='pic-1' src='http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/shop-icon.png'>"+
                        "<img class='pic-2' src='http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/shop-icon.png'>"+
                    "</a></div>"+
               
                "<div class='product-content'>"+
                    "<h3 class='title'>"+data[i].shop.shopname+"</h3>"+
					"<h3 class='title'>distance : "+parseInt(data[i].distance_to_client)+" meters</h3>"+
                    "<button class='btn btn-primary' id="+data[i].shop.id+" ng-click='likedShop($event)'><i class='fa fa-thumbs-o-up '></i>LIKE</button>"+
					"<button class='btn btn-danger' id="+data[i].shop.id+" ng-click='dislikedShop($event)'><i class='fa fa-thumbs-o-down '></i>DISLIKE</button>"+
                    "</div>"+
                   
                "</div></div></div>";
				
				}
				
				
				var divElement = angular.element(document.querySelector('#you'));
				var htmlElement = angular.element(htmlContainer);
				divElement.empty();
				divElement.append(htmlElement);
				$compile(divElement)($scope);
					

            });
		
       
    };
	
	
	/* get liked shops list */ 
	
	 $scope.listLikedShop = function() {
		/* Get current user location */ 
    
	if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            $scope.$apply(function() {
				
                $scope.latitude = position.coords.latitude;
				$scope.longitude = position.coords.longitude;
				
			
            });
        });
    }
	/* Get current user location */ 
	
	
	
	/* Get the list of shops sorted by distance between client and shops*/
	 $http({
                method: 'post',
                headers: {
					'Content-Type': 'application/x-www-form-urlencoded',
                    "Authorization": $scope.TType + " " + $scope.Token
                },
                url: 'http://localhost:9090/list/shop/allLiked',
				data: 'latitude_Client='+$scope.latitude+'&longitude_Client='+$scope.longitude+'&email='+$scope.userName
            })
            .success(function(data) {
				if(data.length>0){
				var htmlContainer = "";
				
				
				for(var i=0;i<data.length;i++){
					htmlContainer += "<div class='col-md-3 col-sm-6'><div class='product-grid'><div class='product-image'> <a href='#'>"+
                        "<img class='pic-1' src='http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/shop-icon.png'>"+
                        "<img class='pic-2' src='http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/shop-icon.png'>"+
                    "</a></div>"+
               
                "<div class='product-content'>"+
                    "<h3 class='title'>"+data[i].shop.shopname+"</h3>"+
					"<h3 class='title'>distance : "+parseInt(data[i].distance_to_client)+" meters</h3>"+
                    "<button class='btn btn-danger' id="+data[i].shop.id+" ng-click='removeLiked($event)'><i class='fa fa-thumbs-o-up '></i>Remove</button>"+
                    "</div>"+
                   
                "</div></div></div>";
				
				}
				
				var divElement = angular.element(document.querySelector('#you'));
				var htmlElement = angular.element(htmlContainer);
				divElement.empty();
				divElement.append(htmlElement);
				$compile(divElement)($scope);
			}
			else{
				$scope.alertMsg = true;
				$scope.alertMessage = "Nothing available";
			}

            });
		
       
    };
	
	
	
	
});