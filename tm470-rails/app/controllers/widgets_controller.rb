class WidgetsController < ApplicationController
  def show
    @widget = Widget.find(params[:id])
  end
  def new

  end


  def create
    @widget = Widget.new(widget_params)

    @widget.save

    redirect_to @widget
  end

  private

  def widget_params
    params.require(:widget).permit(:name, :purpose, :size, :id)
  end

end
