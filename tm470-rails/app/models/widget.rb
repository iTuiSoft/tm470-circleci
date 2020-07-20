class Widget < Flexirest::Base
  request_body_type :json

  base_url = Rails.application.config.widget_service_config[:host]

  get :all, base_url + "external/widgets/"

  get :find, base_url + "external/widget/:id/"

  post :create, base_url + "external/widget/add/", plain: true

end
