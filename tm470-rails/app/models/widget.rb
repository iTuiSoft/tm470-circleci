class Widget < Flexirest::Base
  request_body_type :json

  base_url = Rails.application.config.widget_service_config[:host]

  get :all, base_url + "api/widgets/"

  get :find, base_url + "api/widget/:id/"

  post :create, base_url + "api/widget/add/", plain: true

end
