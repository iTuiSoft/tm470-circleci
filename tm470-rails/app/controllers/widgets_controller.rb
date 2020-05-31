class WidgetsController < ApplicationController
  def index
    @widgets = Widget.all
  end

  def show
    id = params[:id]
    @widget = Widget.find(id)
  end

  def new

  end

  def create
    widget_id = Widget.create(
        name: widget_params[:name],
        purpose: widget_params[:purpose],
        size: widget_params[:size]
    )

    redirect_to widget_path(widget_id)

  end

  private

  def widget_params
    params.require(:widget).permit(:name, :purpose, :size)
  end

end
