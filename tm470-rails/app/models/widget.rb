class Widget < Flexirest::Base
  request_body_type :json

  base_url = "http://localhost:8080/api"

  get :all, base_url + "/widgets/"

  get :find, base_url + "/widget/:id/"

  post :create, base_url + "/widget/add/", plain: true

end
