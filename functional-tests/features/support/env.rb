require 'bundler/setup'
Bundler.require

Config.load_and_set_settings(Config.setting_files('./config', ENV['ENVIRONMENT'] || 'local'))