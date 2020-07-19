Rails.application.routes.draw do
  get 'welcome/index'

  resources :widgets

  root 'welcome#index'
end
