class CreateWidgets < ActiveRecord::Migration[5.2]
  def change
    create_table :widgets, id: false do |t|
      t.string :name
      t.text :purpose
      t.integer :size
      t.integer :id

      t.timestamps
    end
  end
end
