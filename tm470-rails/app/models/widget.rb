class Widget < ApplicationRecord
  validates :name, presence: true, length: { minimum: 3 }
  validates :size, presence: true, numericality: { only_integer: true }
end
