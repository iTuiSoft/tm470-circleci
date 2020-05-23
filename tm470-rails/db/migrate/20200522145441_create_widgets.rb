class CreateWidgets < ActiveRecord::Migration[5.2]
  def change
    create_table :widgets  do |t|
      t.string :name
      t.text :purpose
      t.integer :size

      t.timestamps
    end
  end
end
